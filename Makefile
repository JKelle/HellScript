all:
	scalac -d bin src/HellScript.scala src/HelloWorld.scala

run:
	scala -classpath bin/ HelloWorld

clean:
	rm -f bin/*
