FROM maven

RUN groupadd -r user --gid="1000" \
    && adduser --gid "1000" --uid "1000" --home "/home/user" --gecos '' --shell "/bin/bash" --disabled-password --disabled-login user \
    && chown -R user /home/user

COPY docker-entrypoint.sh /

VOLUME "/app"
WORKDIR "/app"
USER user

ENTRYPOINT ["/docker-entrypoint.sh"]
CMD []
