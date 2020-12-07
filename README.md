YLingua
(v. pre-Alpha 1.2.0)

Приложение делаю исключительно для себя, но если вдруг кому-то надо, берите (хотя, возможно, стоит сперва поискать более хорошие аналоги).
Проект создан в среде Android Studio.
Далее следует краткое руководство пользователя.

Это предварительная версия приложения. В ней отсутствуют некоторые функции и присутствуют некотороые баги. Но здесь, по крайней мере, есть уже более или менее нормальные иконки. Во всяком случае, мне они кажутся нормальными.

# Руководство пользователя
## Начало работы
Приложение YLingua предназначено для упрощения процесса изучения и повторения иностранных слов. Пользователь вводит список языков, которые он планирует изучать, а также указывает слова, которые будет повторять. После выбора нужного языка приложение случайный образом выбирает одно из введённых ранее слов и выводит его на экран, а пользователь должен верно указать его перевод.

## Добавление языков
Сперва необходимо ввести список языков. Допустим, наш родной язык русский, но мы также изучаем английский и французский. Для правильной работы требуется указать все три языка (включая родной).
Для этого нажимаем на кнопку «Редактировать языки» («Edit languages»). Затем жмём на появившуюся кнопку «Добавить язык» («Add language»). В появившемся диалоговом окне необходимо ввести код языка и его название, после чего нажать кнопку «Добавить» («Add»). После этого добавленный язык отобразится в списке, откуда его можно будет удалить нажатием красного крестика справа. На данный момент возможность изменить название или код языка без его удаления отсутствует.
Таким образом мы добавляем три языка: RU (Русский), EN (Английский) и FR (Французский). Не рекомендуется использовать в качестве кода языка более двух букв: это может привести к некорректному построению пользовательского интерфейса.

## Добавление слов
Чтобы добавить в приложение слова, сперва необходимо выбрать два языка (язык самого слова и перевода) с помощью выпадающих списков в верхней части экрана. В качестве примера выберем RU и EN. После этого надо нажать на кнопку «Словарь» («Dictionary»).
Нажатие на появившуюся кнопку «Добавить слово» («Add word») приведёт к появлению диалогового окна, где пользователю необходимо ввести слово и его перевод. Например, введём «apple» и «яблоко». После этого требуется нажать кнопку «Сохранить» («Save»). В списке появится новая пара слов. Флажки справа и слева обозначают то, выучили ли вы данное слово. Вы можете поставить флажок, если считаете, что уже знаете слово и не хотите, чтобы во время тренировки оно вам попадалось (обратите внимание, что выученные слова всё равно будут попадаться, но значительно реже). Для разнообразия таким же способом добавим «door» и «дверь». В списке слов все слова отсортированы в алфавитном порядке, нажатие на элемент списка приведёт к открытию диалогового окна, где его можно изменить или удалить.
Теперь вернёмся на главный экран и изменим в выпадающем списке «EN» на «FR». Список слов вновь окажется пустым (ведь мы ещё не ввели ни одного французского слова). Исправим это — уже знакомым нам способом добавим «une fenêtre» — «окно» и «une lampe» — «лампа».

## Собственно тренировка
Переключение в режим «Тренировка» («Training») приведёт к появлению кнопки «Начать тренировку» («Start training»). Перед её нажатием проверьте, указали ли вы верные языки в выпадающих списках сверху (вам будет необходимо переводить слова с одного из них на другой). Если вы хотите, чтобы выученные слова попадались наравне с невыученными, поставьте флажок «Вместе с выученными» («With learned»). После начала тренировки перед вами появится жёлтая карточка, на которой крупным шрифтом будет написано одно из введённых вами ранее слов на одном из указанных языков (если карточка серая, а на месте слова написано «Ошибка» \[«Error»], перейдите в словарь и добавьте хотя бы одну пару слов). В поле для ввода вам нужно написать перевод этого слова (с версии Alpha 1.1.0 это поле не чувствительно к регистру), а затем нажать кнопку «Ответить» справа. Если ответ верный, карточка станет зелёной, иначе — красной (в этом случае вверху появится верный ответ). Появившимся при правильном ответе флажоком «Отметить выученным» («Set as learned») вы можете, как можно догататься по названию флажка, отметить слово выученным, если считаете, что вы его выучили. Обратите внимание, что неверный ответ приводит к потере статуса выученного. Нажмите «Далее», чтобы продолжить.

## Запланированные возможности
На главном экране можно найти кнопки «Темы» («Themes») и «Настройки». На данный момент эти возможности ещё не были реализованы.

# История версий
- **pre-Alpha 1.2.0**
  - Полностью переработаны внешний вид и навигация в приложении.
- **Alpha 1.1.2**
  - Изменён дизайн приложения: радиокнопки заменены на вкладки, в режиме тренировки добавлена кнопка выхода.
- **Alpha 1.1.1**
  - Исправлена ошибка:
    - при обновлении списка слов словарь прокручивался в самое начало.
- **Alpha 1.1.0**
  - Добавлена возможность отмечать слова выученными. В этом случае во время тренировки они будут попадаться значительно реже (если не стоит флажок «Повторять выученные слова» \["Repeat the learned words"]). Если перевод выученного слова неверен, оно вновь становится невыученным.
  - Теперь во время тренировки программа не обращает внимания на регистр вводимых символов.
  - Исправлены ошибки:
    - редкие вылеты в режиме словаря из-за обработки интерфейса в неверном потоке;
	- при большом количестве слов в словаре попытка изменения слов, расположенных ниже, приводит к изменению верхних слов.
- **Alpha 1.0.1**
  - Изменение дизайна карточек для повторения слов:
    - кнопка «Ответить» уменьшена и перенесена в место, где её не будет закрывать виртуальная клавиатура;
	- вместо кнопки «Ответить» теперь можно использовать клавишу «Ввод» на клавиатуре;
	- в случае неверного ответа в верней половине карточки появится правильный ответ;
	- теперь на карточке даже длинные выражения выравниваются по центру (ранее, если выражение для перевода занимало более одной строки, то оно выравнивалось по левому краю.
  - Из режима редактирования языков теперь можно выйти клавишей «Назад».
- **Alpha 1.0.0**