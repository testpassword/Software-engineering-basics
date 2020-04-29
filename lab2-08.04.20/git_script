#!/bin/bash
cd SEB
git init gRepo
cd gRepo

git config --global user.name "red"
git config --global user.email "red@m.com"
cp ../src/com0/* .
git add .
git commit -m "r0"

touch q
# делаем изменения в локальном репозитории
git add .
git commit -m "r1"

touch w 
# делаем изменения в локальном репозитории
git add .
git commit -m "r2"

git checkout -b branch2
touch e 
# делаем изменения в локальном репозитории
git add .
git commit -m "r3"

touch r 
# делаем изменения в локальном репозитории
git add .
git commit -m "r4"

git config --global user.name "blue"
git config --global user.email "blue@m.com"
git checkout -b branch3
touch t 
# делаем изменения в локальном репозитории
git add .
git commit -m "r5"

git config --global user.name "red"
git config --global user.email "red@m.com"
git checkout branch2
touch y 
# делаем изменения в локальном репозитории
git add .
git commit -m "r6"

git config --global user.name "blue"
git config --global user.email "blue@m.com"
git checkout branch3
touch u 
# делаем изменения в локальном репозитории
git add .
git commit -m "r7"

touch i 
# делаем изменения в локальном репозитории
git add .
git commit -m "r8"

git config --global user.name "red"
git config --global user.email "red@m.com"
git checkout branch2
touch o 
# делаем изменения в локальном репозитории
git add .
git commit -m "r9"

touch p 
# делаем изменения в локальном репозитории
git add .
git commit -m "r10"

git config --global user.name "blue"
git config --global user.email "blue@m.com"
git checkout branch3
git merge --no-commit branch2
touch a 
# делаем изменения в локальном репозитории
git add .
git commit -m "r11"

git config --global user.name "red"
git config --global user.email "red@m.com"
git checkout master
touch s 
# делаем изменения в локальном репозитории
git add .
git commit -m "r12"

git config --global user.name "blue"
git config --global user.email "blue@m.com"
git checkout branch3
touch d 
# делаем изменения в локальном репозитории
git add .
git commit -m "r13"

git config --global user.name "red"
git config --global user.email "red@m.com"
git checkout master
git merge --no-commit branch3
touch f 
# делаем изменения в локальном репозитории
git add .
git commit -m "r14"