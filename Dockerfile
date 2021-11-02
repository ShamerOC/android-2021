FROM ubuntu:20.04

ENV TZ=Europe/Warsaw
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone 

RUN apt update && apt install -y build-essential unzip vim git curl wget zip

RUN apt-get update &&\
	apt-get upgrade -y &&\
    apt-get install -y  software-properties-common

RUN useradd -ms /bin/bash krzysztof
RUN adduser krzysztof sudo

USER krzysztof
WORKDIR /home/krzysztof
RUN curl -s "https://get.sdkman.io" | bash
RUN chmod a+x "$HOME/.sdkman/bin/sdkman-init.sh"

RUN /bin/bash -c "source $HOME/.sdkman/bin/sdkman-init.sh && sdk install java 11.0.13-zulu"	
RUN /bin/bash -c "source $HOME/.sdkman/bin/sdkman-init.sh && sdk install gradle 7.2"
RUN /bin/bash -c "source $HOME/.sdkman/bin/sdkman-init.sh && sdk install kotlin 1.5.31"

ENV PATH=/home/krzysztof/.sdkman/candidates/java/current/bin:$PATH
ENV PATH=/home/krzysztof/.sdkman/candidates/gradle/current/bin:$PATH
ENV PATH=/home/krzysztof/.sdkman/candidates/kotlin/current/bin:$PATH