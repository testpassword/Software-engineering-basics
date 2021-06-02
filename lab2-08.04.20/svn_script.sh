# подготовка
svnadmin create repo #создаём репозиторий
cd repo
svn mkdir -m “project structure” file:///home/s265570/SEB/repo/trunk file:///home/s265570/SEB/repo/branches #создаём структуру проекта
cd ..
svn checkout file:///home/s265570/SEB/repo/trunk/ workDir #создаём рабочую копию
cd workDir

# r0
cp ~/SEB/src/com0/* .
svn add *
svn commit -m “r0” –-username=Pupa

# r1
svn rm * #удаляем файлы из рабочей директории (если это не сделать, то нельзя будет сделать коммит, т.к. новые файлы ничем не отличаются от старых)
cp ~/SEB/src/com1/* .
svn add *
svn commit -m “r1” –-username=Pupa

# r2
svn rm *
cp ~/SEB/src/com2/* .
svn add *
svn commit -m “r2” –-username=Pupa

# r3
svn copy file:///home/s265570/SEB/repo/trunk file:///home/s265570/SEB/repo/branches/branch2 -m “created branch2”
svn switch file:///home/s265570/SEB/repo/branches/branch2
svn rm *
cp ~/SEB/src/com3/* .
svn add *
svn commit -m “r3” –-username=Pupa

# r4
svn rm *
cp ~/SEB/src/com4/* .
svn add *
svn commit -m “r4” –-username=Pupa

# r5
svn copy file:///home/s265570/SEB/repo/branches/branch2 file:///home/s265570/SEB/repo/branches/branch3 -m “created branch3” –username=Lupa
svn switch file:///home/s265570/SEB/repo/branches/branch3
svn rm *
cp ~/SEB/src/com5/* .
svn add *
svn commit -m “r5” –-username=Lupa

# r6
svn switch file:///home/s265570/SEB/repo/branches/branch2
svn rm *
cp ~/SEB/src/com6/* .
svn add *
svn commit -m “r6” -–username=Pupa

# r7
svn switch file:///home/s265570/SEB/repo/branches/branch3
svn rm *
cp ~/SEB/src/com7/* .
svn add *
svn commit -m “r7” -–username=Lupa

# r8
svn rm *
cp ~/SEB/src/com8/* .
svn add *
svn commit -m “r8” -–username=Lupa

# r9
svn switch file:///home/s265570/SEB/repo/branches/branch2
svn rm *
cp ~/SEB/src/com9/* .
svn add *
svn commit -m “r9” -–username=Pupa

# r10
svn rm *
cp ~/SEB/src/com10/* .
svn add *
svn commit -m “r10” -–username=Pupa

# r11
svn switch file:///home/s265570/SEB/repo/branches/branch3
svn merge file:///home/s265570/SEB/repo/branches/branch2
svn rm * --force
cp ~/SEB/src/com11/* .
svn add *
svn commit -m “r11” –username=Lupa

# r12
svn switch file:///home/s265570/SEB/repo/trunk
svn rm *
cp ~/SEB/src/com12/* .
svn add *
svn commit -m “r12” –username=Pupa

# r13
svn switch file:///home/s265570/SEB/repo/branches/branch3
svn rm *
cp ~/SEB/src/com13/* .
svn add *
svn commit -m “r13” -–username=Lupa

# r14
svn switch file:///home/s265570/SEB/repo/trunk
svn merge file:///home/s265570/SEB/repo/branches/branch3
svn rm * --force
cp ~/SEB/src/com14/* .
svn add *
svn commit -m “r14” –username=Pupa