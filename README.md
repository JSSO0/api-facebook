# api-facebook
Api for receive webhooks for Facebook Mensseger
# Modelo UML 
![alt text](image.png)
# Modelo do Banco
![alt text](image-1.png)
# Caminho da mensagem na API
![alt text](image-2.png)

# Query usada para gerar as tabelas do Banco

-- Tabela User
CREATE TABLE User (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    id_webhook VARCHAR(255),
    mensagens INT REFERENCES mensage(id)
);

-- Tabela Message
CREATE TABLE Message (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    mensage_date DATE,
    sender_id UUID REFERENCES sender(id),
    content_mensage TEXT,
    receiver_id VARCHAR(255) REFERENCES User(id_webhook)
);

-- Tabela Sender
CREATE TABLE Sender (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    id_sender_webhook VARCHAR(255),
    mensages_send UUID REFERENCES Message(id)
);


#INFOS:

"access_token": "EAAH0hV9SFyIBOwcPh07NCSAMf2fNxGewUbsZBBNVr3oFLEZA66C3V6OF8Q44L7apdq6TA3LXQfhy2W0ckigTAJV3BnGUMyansJMZANyQcvlGDyTCToeWR6DndrjpQbccpDHZBuseChlmRTg0ZCgWBH9ZAVwkW1l9jtbEcdErPYVt49wBgUpNZADcCIlSjjX6jmWVnLgxDbHRp9OmpOrV0vn1j9fN5j3smFK",
"name": "Teste botinho",
"id": "300107813175496",
"access_token": "EAAH0hV9SFyIBO7ZBkxOZCvYSkEpdPeHaJrBUnQrL92PvMQOLHxiDUHDqWk5IKz3rMCFs1bDa5U48tpXraS9jKlghIS3HZCaUpds9noG2ZB0rhp1QZCSnYNhP98PgIuOJ3FJLyy0Pfxx0T1sNquFfV03CSJPDU5REZAsTdIQNdjekmiGtUvMnBjcjZClmd3MaMteXJ8oWiqLnUB4zbIb9LIZAyTDZBPHDwhgGc",


curl -i -X GET \
"https://graph.facebook.com/v19.0/me/accounts?access_token=EAAH0hV9SFyIBO9Rf31Q1z0AaDvo0YnJsd9KIx2ZB6x9EKEJMpokbxIeXEhhZCIwNa2NNr10IJUgCCe4uZCZAtEBWziCskKliXoJAyKSbZCZBZAnZBXs9bdV7OhXwt1N5SqML4VabMwxxYWUNVBLznb21cPwK1ywqZAoNxnwAx4owh9eoXWaYzwsLZCYCwvgLm2BChcNouAl37J0AQMN9Cnjd9hO2DwqgZDZD"

{
"name": "Joely Silva",
"id": "137949749238014"
}

curl -i -X GET \
"https://graph.facebook.com/v19.0/me?fields=name%2Cid&access_token=EAAH0hV9SFyIBO9Rf31Q1z0AaDvo0YnJsd9KIx2ZB6x9EKEJMpokbxIeXEhhZCIwNa2NNr10IJUgCCe4uZCZAtEBWziCskKliXoJAyKSbZCZBZAnZBXs9bdV7OhXwt1N5SqML4VabMwxxYWUNVBLznb21cPwK1ywqZAoNxnwAx4owh9eoXWaYzwsLZCYCwvgLm2BChcNouAl37J0AQMN9Cnjd9hO2DwqgZDZD"

{
"data": [
{
"participants": {
"data": [
{
"name": "Joely Silva",
"email": "7612696888751001@facebook.com",
"id": "7612696888751001"
},
{
"name": "Teste botinho",
"email": "300107813175496@facebook.com",
"id": "300107813175496"
}
]
},
"messages": {
"data": [
{
"id": "m_TwuhFxQHNyaGSKwePZAKmCfA9H70pPrG3z_MeRPmDw4jehyMs0eW1cRJgdzE75JRjUHcqylHEkQe52iZnWhP4Q",
"message": "eae chefe"
}
],
"paging": {
"cursors": {
"before": "QVFIUmowLTl4RkFQOXhzV1UxNnJjUjJtNXQ0bHJSaXdfWXNERm10a3gxR29hVmFkdl9zeHVVUTRTSlRaVzdaRmFmb3dkd1ZAWT2RkYXE2anBkVWx0TERoS0ZAmVEZALTldmTzJHNjZAEM1AxTE9pUlBaTm03UjJxbUpKTlE2LTREUDJlbjRG",
"after": "QVFIUmowLTl4RkFQOXhzV1UxNnJjUjJtNXQ0bHJSaXdfWXNERm10a3gxR29hVmFkdl9zeHVVUTRTSlRaVzdaRmFmb3dkd1ZAWT2RkYXE2anBkVWx0TERoS0ZAmVEZALTldmTzJHNjZAEM1AxTE9pUlBaTm03UjJxbUpKTlE2LTREUDJlbjRG"
}
}
},
"id": "t_366180373081616"
}
],
"paging": {
"cursors": {
"before": "QVFIUjJOa1NWdm9CU0NxcnZAPNW5TVUotX3NUTDJuY3I4VDhHc0w4X3F6b0hyS3BJdXdqVmNsZAkZArTTYycGNVc3RmX2lFSXdjQ1FQMGVOMWhjSnlXUUZADaGx1Nzk4WTl6cldmZA3hNNU1yNkpjc210blJyNlBRMGpIQnZAEZAE9GNW5DZAkQx",
"after": "QVFIUjJOa1NWdm9CU0NxcnZAPNW5TVUotX3NUTDJuY3I4VDhHc0w4X3F6b0hyS3BJdXdqVmNsZAkZArTTYycGNVc3RmX2lFSXdjQ1FQMGVOMWhjSnlXUUZADaGx1Nzk4WTl6cldmZA3hNNU1yNkpjc210blJyNlBRMGpIQnZAEZAE9GNW5DZAkQx"
}
}
}
curl -i -X GET \
"https://graph.facebook.com/v19.0/300107813175496/conversations?fields=participants%2Cmessages%7Bid%2Cmessage%7D&access_token=EAAGEWHmp5oABO2PkwDkZBmU80LwByhLp3DXZByZBSl4X54PTUpgB5irZBYHjb0Uw6Y38yxi22gsayEZB2ZAZCyGI0IuRl83CBtG1a2gyZCZBvvwhelYLCnAUWr9DKWdWjS6ANaDzyEzobXRlozPTwZAu88bfDZBgDdWmWCXyOEG7QcnwaCRazIGPIH5G7pEt5QJLZCFdTjlqlayRAR881gcQ0XjD3EyfeBycdBAs"

{
"recipient_id": "7612696888751001",
"message_id": "m_8juDru7sB_YbxeqEwFVxBifA9H70pPrG3z_MeRPmDw5BRlpLhwZpoEeZh0-nPOPGKhAWR8en3PaTRj4CtzzNig"
}
curl -i -X POST \
"https://graph.facebook.com/v19.0/me/messages?recipient=%7Bid%3A7612696888751001%7D&mesaging_type=RESPONSE&message=%7B%22text%22%3A%22opa%22%7D&access_token=EAAGEWHmp5oABO2PkwDkZBmU80LwByhLp3DXZByZBSl4X54PTUpgB5irZBYHjb0Uw6Y38yxi22gsayEZB2ZAZCyGI0IuRl83CBtG1a2gyZCZBvvwhelYLCnAUWr9DKWdWjS6ANaDzyEzobXRlozPTwZAu88bfDZBgDdWmWCXyOEG7QcnwaCRazIGPIH5G7pEt5QJLZCFdTjlqlayRAR881gcQ0XjD3EyfeBycdBAs"
![img.png](img.png)

 {"object":"page",
 "entry":[{"time":1713395468795,
 "id":"300107813175496",
 "messaging":[{"sender":{"id":"7612696888751001"},
 "recipient":{"id":"300107813175496"},
 "timestamp":1713394482342,
 "message":{"mid":"m_X4bci5SUeCNe3N6TpUDLLifA9H70pPrG3z_MeRPmDw61-eoTbbcmvbNRW-MISLK3DLO_ZOYUM8N0VfVSJ3t5ig","text":"oi"}}]}]
 }