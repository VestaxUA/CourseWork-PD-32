<h1>Деталі офісу</h1>
<div>
    <strong>Назва:</strong> ${office.name}<br>
    <strong>Опис:</strong> ${office.description}<br>
    <strong>Телефон:</strong> ${office.phone}<br>
    <strong>Номер кабінету:</strong> ${office.roomNumber}<br>
    <strong>Відповідальна особа:</strong> ${office.responsiblePerson}
</div>
<div>
    <form action="/offices/${office.id}/add-safety-instructions" method="post">
        <label for="safetyInstructions">Додати інструкції з охорони праці:</label>
        <select id="safetyInstructions" name="safetyInstructionsIds" multiple>
            <#if allSafetyInstructions??>
                <#list allSafetyInstructions as safetyInstruction>
                    <option value="${safetyInstruction.id}">${safetyInstruction.instruction}</option>
                </#list>
            </#if>
        </select>
        <button type="submit">Додати</button>
    </form>
</div>
<div>
    <h2>Існуючі інструкції з охорони праці:</h2>
    <ul>
        <#if safetyInstructions?has_content>
            <#list safetyInstructions as instruction>
                <li>${instruction.instruction}</li>
            </#list>
        <#else>
            <li>Інструкції відсутні</li>
        </#if>
    </ul>
</div>
<div>
    <a href="/offices">Повернутись до списку офісів</a>
</div>