import requests
from bs4 import BeautifulSoup

mean = raw_input('Enter a meaning: ')
page = requests.get('http://hindi-english.org/index.php?input='+mean+'&trans=Translate&direction=AU')
soup = BeautifulSoup(page.content, 'html.parser')
p = soup.find_all(class_='stil9')
for i in range(len(p)):
    print p[i].get_text()
