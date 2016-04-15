mkdir temp
for file in ./*.scala
  do
    echo "Compiling $file"
    scalac -d temp/ -classpath ../bin "$file"
    echo "Running $file"
    scala -classpath ../bin "$file"
  done
rm -rf temp
