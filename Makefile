all:
	scalac -d bin src/TypeScript.scala src/HelloWorld.scala

run:
	scala -classpath bin/ HelloWorld

clean:
	rm -f bin/*
	rm -f src/*.class
