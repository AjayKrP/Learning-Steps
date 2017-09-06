import numpy as np
import pandas as pd

randn = np.random.rand

#s = Series(data, index=index)

#Array Like

s = pd.Series(randn(5), index=['a', 'b', 'c', 'd', 'e'])

#print s.index
#print pd.Series(randn(5))

#Dictionary

#d = {'a' : 0., 'b' : 1., 'c' : 2.}

#print pd.Series(d)
#print pd.Series(d, index=['b', 'c', 'd', 'a'])

#Scalar

#print pd.Series(5., index=['a', 'b', 'c', 'd', 'e'])


#Series is similar to array
#print s[0]

# print s[s > s.median()]


# print s[[4, 3, 1]]
# print s + s
# print s* 2
# print np.exp(s)

#Series is similar to dictionary

print s['a']

print 'a' in s

s['a'] = 12

#Name attribute

s = pd.Series(np.random.randn(5), name='random series')

print s