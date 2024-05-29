<h1>Інструкції з охорони праці</h1>

<h2>Додати нову інструкцію з охорони праці</h2>
<form action="/safety-instructions" method="post">
    <div>
        <label for="instruction">Інструкція:</label>
        <textarea id="instruction" name="instruction" required></textarea>
    </div>
    <button type="submit">Додати</button>
</form>

<h2>Список інструкцій з охорони праці</h2>
<ul>
    <#if safetyInstructions?has_content>
        <#list safetyInstructions as safetyInstruction>
            <li>${safetyInstruction.instruction}</li>
            <form action="/safety-instructions/delete/${safetyInstruction.id}" method="post">
                <button type="submit">Видалити</button>
            </form>
        </#list>
    <#else>
        <li>Немає інструкцій з охорони праці</li>
    </#if>
</ul>

<a href="/offices">Повернутися до списку офісів</a>