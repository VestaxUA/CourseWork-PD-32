<h1>Список офісів</h1>
<!-- Відображення списку офісів -->
<ul>
    <#list offices as office>
        <li>
            Офіс: <a href="/offices/${office.id}">${office.name}</a> (Опис: ${office.description}, Телефон: ${office.phone}, Номер кабінету: ${office.roomNumber}, Відповідальна особа: ${office.responsiblePerson})
            <form action="/offices/delete/${office.id}" method="post" style="display:inline;">
                <input type="submit" value="Видалити">
            </form>
        </li>
    </#list>
</ul>
<!-- Форма для додавання нового офісу -->
<h2>Додати новий офіс</h2>
<form action="/offices/create" method="post" accept-charset="UTF-8">
    <div>
        <label>Назва офісу:</label>
        <input type="text" name="name" required>
    </div>
    <div>
        <label>Опис:</label>
        <input type="text" name="description" required>
    </div>
    <div>
        <label>Телефон:</label>
        <input type="text" name="phone" required>
    </div>
    <div>
        <label>Номер кабінету:</label>
        <input type="text" name="roomNumber" required>
    </div>
    <div>
        <label>Відповідальна особа:</label>
        <input type="text" name="responsiblePerson" required>
    </div>
    <button type="submit">Додати</button>
</form>

<div>
    <a href="/safety-instructions">Перейти до списку інструкцій безпеки</a>
</div>
