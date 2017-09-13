FROM base

COPY docker-entrypoint.sh /

VOLUME "/app"
WORKDIR "/app"
USER user

ENTRYPOINT ["/docker-entrypoint.sh"]
CMD []
