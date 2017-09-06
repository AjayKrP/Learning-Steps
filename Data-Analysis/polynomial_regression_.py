import numpy as np
import matplotlib.pyplot as plt
import pandas as pd

# Importing the dataset
dataset = pd.read_csv('dataset.csv')
X = dataset.iloc[:, 0:].values
y = dataset.iloc[:, 1].values
print X, y
from sklearn.linear_model import LinearRegression
lin_reg = LinearRegression()
lin_reg.fit(X, y)

from sklearn.preprocessing import PolynomialFeatures
polynomial = PolynomialFeatures(degree=4)
X_poly = polynomial.fit_transform(X)
polynomial.fit(X_poly, y)
lin_reg2 = LinearRegression()
lin_reg2.fit(X_poly, y)

plt.plot(X, y, 'ro')
plt.plot(X, lin_reg.predict(X), 'b-')
plt.title('Truth or Bluf')
plt.show()


plt.plot(X, y, 'ro')
plt.plot(X, lin_reg2.predict(polynomial.fit_transform(X)), 'g-')
plt.show()


X_grid = np.arange(min(X), max(X), 0.1)
X_grid = X_grid.reshape(len(X_grid, 1))
plt.plot(X, y, 'ro')
plt.plot(X_grid, lin_reg2.predict(polynomial.fit_transform(X)), 'g-')
plt.show()

# Predicting a new result with Linear Regression
lin_reg.predict(6.5)

# Predicting a new result with Polynomial Regression
lin_reg2.predict(polynomial.fit_transform(6.5))