FROM        ubuntu:18.04

ARG         MEDIA_SERVER_ZIP=ant-media-server-2.1.0-community-2.1.0-20200720_1340.zip
ARG         USER=ant

ENV         DEFAULT_MEDIA_SERVER_ZIP=${MEDIA_SERVER_ZIP}
ENV         DEFAULT_USER=${USER}
ENV         DEBIAN_FRONTEND=noninteractive

RUN         rm /bin/sh && ln -s /bin/bash /bin/sh

RUN         apt-get update --fix-missing

RUN         buildDeps="libx11-dev \
                       unzip \
                       openjdk-8-jdk \
                       ca-certificates \
                       p11-kit" && \
            apt-get -y install ${buildDeps}

RUN \
            groupadd -r -g 2001 ${DEFAULT_USER} && useradd -r -u 1001 -g ${DEFAULT_USER} ${DEFAULT_USER} && \
            mkdir -p /home/${DEFAULT_USER} && chown ${DEFAULT_USER} /home/${DEFAULT_USER}

USER        ${DEFAULT_USER}

COPY        --chown=${DEFAULT_USER} ${DEFAULT_MEDIA_SERVER_ZIP} /tmp
COPY        --chown=${DEFAULT_USER} webapps /tmp/webapps

RUN \
            DIR=/home/${DEFAULT_USER} && \
            unzip -d ${DIR} /tmp/${DEFAULT_MEDIA_SERVER_ZIP} && \
            f=(${DIR}/*) && mv ${DIR}/*/* ${DIR} && \
            rmdir "${f[@]}" && rm -rfv /tmp/${DEFAULT_MEDIA_SERVER_ZIP}

RUN \
            DIR=/home/${DEFAULT_USER} && \
            cp /tmp/webapps/root/WEB-INF/web.xml ${DIR}/webapps/root/WEB-INF/web.xml && \
            cp /tmp/webapps/LiveApp/WEB-INF/web.xml ${DIR}/webapps/LiveApp/WEB-INF/web.xml && \
            cp /tmp/webapps/WebRTCApp/WEB-INF/web.xml ${DIR}/webapps/WebRTCApp/WEB-INF/web.xml && \
            rm -rfv /tmp/webapps

LABEL       MAINTAINER="DongHoon Kang <dhkang@poscoict.com>"

WORKDIR     /home/${DEFAULT_USER}

ENTRYPOINT [ "/bin/bash", "-c", "/home/${DEFAULT_USER}/start.sh" ]

