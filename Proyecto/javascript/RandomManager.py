#-*- coding utf-8 -*-
import random

def randomInt (self,min=0, max=100) :
    r= random.random()
    return int (r*(max-min)+min)

def randomChar(self):
    alphabet="abcdefghijklmnñopqrstuvwxyzáéíóúü"
    return alphabet[self.randomInt(0,len(alphabet))]

def  randomWord(self):
    min=2
    max=self.randomInt(2,8)
    word=""
    for i in range(min, max):
        word+=self.randomChar()
        return word


