describe('testsuite', () => {
    it('opening app',async () => {
        await driver.pause(5000);
    });

    it('operations',async () => {
        await $('~Show Invisible Contacts (Only)').click();
        await $('~Show Invisible Contacts (Only)').click();
    
        await $('~Add Contact').click();
        await $('//android.widget.EditText[@resource-id="com.example.android.contactmanager:id/contactNameEditText"]').addValue('Kakashi');
        await $('//android.widget.EditText[@resource-id="com.example.android.contactmanager:id/contactPhoneEditText"]').addValue('8569632');
        await $('//android.widget.EditText[@resource-id="com.example.android.contactmanager:id/contactEmailEditText"]').addValue('kakashi@hmail.com');
        await $('~Save').click();








        
    });
//dnt    
});