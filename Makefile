all:
	scalac -language:reflectiveCalls -language:dynamics -d bin -feature src/HellScript.scala src/HelloWorld.scala

run:
	scala -classpath bin/ HelloWorld

clean:
	rm -f bin/*
