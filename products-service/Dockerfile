FROM python:3

ADD . /code
WORKDIR /code

RUN pip install pipenv
RUN pip install flask
RUN pip install requests-toolbelt
RUN pip install gunicorn

ENTRYPOINT ["python"]
CMD ["run.py"]
