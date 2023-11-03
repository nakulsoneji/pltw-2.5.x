JAVA   := java
JAVAC  := javac
SRC    := $(wildcard *.java)
CLASS  := $(patsubst %.java, %.class, $(SRC))
RUNNER := Runner.java

all: $(CLASS)

%.class: %.java
	$(JAVAC) $<

.PHONY: run
run: $(CLASS)
	$(JAVA) $(RUNNER)
	
.PHONY: clean
clean:  
	rm -f $(CLASS)
