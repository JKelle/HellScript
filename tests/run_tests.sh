cp ../src/HellScript.scala ./
scalac *.scala
echo "~compiling HelloWorld~"
echo "~compiling Add~"
echo "~compiling If~"
echo "~compiling Func~"
echo "~running HelloWorld~"
scala HelloWorld
echo "~running Add~"
scala Add
echo "~running If~"
scala If
echo "~running Func~"
scala Func
rm *.class
rm HellScript.scala

