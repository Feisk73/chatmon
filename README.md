# ChatMon Plugin for Nukkit

## Описание

ChatMon - это плагин для Nukkit, который добавляет локальной и глобальный чат с возможностью кастомизации сообщений.
## Основные функции

- 🌍 **Глобальный чат** - общение со всеми игроками на сервере
- 🏠 **Локальный чат** - общение только с nearby игроками (настраиваемый радиус)
- 🎨 **Кастомизация сообщений** - гибкая настройка формата сообщений
- 📌 **Поддержка PlaceholderAPI** - использование плейсхолдеров в сообщениях
- ⚙️ **Конфигурируемые настройки** - все параметры можно изменить в config.yml

## Команды

- `/chatmonreload` - перезагружает конфиг плагина

## Разрешения

- `chatmon.command.reload` - доступ к команде /chatmonreload

## Конфигурация

Пример конфигурационного файла (config.yml):

```yaml
# placeholders:
#   %chat_type% – Indicates whether the message was sent to a local or global chat.
#   %name% - Player's display name.
#   %msg% - Player's message.

chat-format: "%chat_type% | %luckperms_prefix% <%name%> %msg%"

scope-label:
  local: "§aL"
  global: "§6G"

radius: 100

globalChatPrefix: "!"

messages:
  no-one-around: "§7Ваше сообщение никто не услышал. Попробуйте написать \"!\" перед своим сообщением"
```