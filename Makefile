all:
	scalac -d bin -feature src/HellScript.scala src/HelloWorld.scala

run:
	scala -classpath bin/ HelloWorld

test:
	./tests/run_tests.sh
clean:
	rm -f bin/*
