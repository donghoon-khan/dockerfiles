### Base stage
FROM        ubuntu:18.04

ARG         MEDIA_SERVER_ZIP=ant-media-server-2.1.0-community-2.1.0-20200720_1340.zip
ARG         WORK_DIR=/usr/local/antmedia

ENV         DEFAULT_MEDIA_SERVER_ZIP=$MEDIA_SERVER_ZIP
ENV         DEFAULT_WORK_DIR=$WORK_DIR
ENV         DEBIAN_FRONTEND=noninteractive

RUN         apt-get update --fix-missing

RUN         buildDeps="libx11-dev \
                       unzip \
                       openjdk-8-jdk \
                       ca-certificates \
                       p11-kit" && \
            apt-get -y install ${buildDeps}

### Build media server stage
# FROM        base as build

COPY        ${DEFAULT_MEDIA_SERVER_ZIP} /tmp
COPY        webapps /tmp/webapps

RUN \
            DIR=/tmp/antmidea && \
            mkdir -p ${DIR} && \
            cp /tmp/${DEFAULT_MEDIA_SERVER_ZIP} ${DIR} && \
            unzip ${DIR}/${DEFAULT_MEDIA_SERVER_ZIP} -d /usr/local/ && \
            rm -rfv /var/lib/apt/lists/* ${DIR} /tmp/${DEFAULT_MEDIA_SERVER_ZIP}

RUN \
            ORIGIN_DIR=/usr/local/ant-media-server && \
            mkdir -p ${DEFAULT_WORK_DIR} && \
            cp -r ${ORIGIN_DIR}/* ${DEFAULT_WORK_DIR} && \
            rm -rfv ${ORIGIN_DIR}

RUN \
            cp /tmp/webapps/root/WEB-INF/web.xml \
               ${DEFAULT_WORK_DIR}/webapps/root/WEB-INF/web.xml && \
            cp /tmp/webapps/LiveApp/WEB-INF/web.xml \
               ${DEFAULT_WORK_DIR}/webapps/LiveApp/WEB-INF/web.xml && \
            cp /tmp/webapps/WebRTCApp/WEB-INF/web.xml \
               ${DEFAULT_WORK_DIR}/webapps/WebRTCApp/WEB-INF/web.xml && \
            rm -rfv /tmp/webapps

### Release stage
# FROM        build as release

MAINTAINER  DongHoon Kang <dhkang@poscoict.com>

WORKDIR     ${DEFAULT_WORK_DIR}

RUN         chmod 755 ${DEFAULT_WORK_DIR}

ENTRYPOINT /bin/bash -c ${DEFAULT_WORK_DIR}/start.sh
