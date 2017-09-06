import numpy as np
import matplotlib.pyplot as plt
import pandas as pd
from sklearn.preprocessing import StandardScaler
from sklearn.linear_model import LinearRegression
from sklearn.model_selection import train_test_split

dataset = pd.read_csv('Salary_Data.csv')

X = dataset.iloc[:, 0].values
y = dataset.iloc[:, 1].values

X_train, X_test, y_train, y_test = train_test_split(X, y, test_size = 0.2, random_state=0)

X_train = np.reshape(X_train, (X_train.shape[0], 1))
X_test = np.reshape(X_test, (X_test.shape[0], 1))
y_train = np.reshape(y_train, (y_train.shape[0], 1))
y_test = np.reshape(y_test, (y_test.shape[0], 1))


regressor = LinearRegression()
regressor.fit(X_train, y_train)

# Predicting the Test set results
y_pred = regressor.predict(X_test)

year = input('Enter your working experience: ')
print regressor.predict(year)
print regressor.coef_
print regressor._residues
print regressor.rank_
# Visualising the Training set results
plt.plot(X_train, y_train, 'ro')
plt.plot(X_train, regressor.predict(X_train), color = 'blue')
plt.plot(year, regressor.predict(year), 'go')
plt.title('Salary vs Experience')
plt.xlabel('Years of Experience')
plt.ylabel('Salary')
plt.xticks()
plt.yticks()
plt.show()

# year  = input('Enter your working year: ')


# Visualising the Test set results
plt.plot(X_test, y_test,'r*')
plt.plot(X_train, regressor.predict(X_train), color = 'blue')
plt.title('Salary vs Experience (Test set)')
plt.xlabel('Years of Experience')
plt.ylabel('Salary')
plt.show()