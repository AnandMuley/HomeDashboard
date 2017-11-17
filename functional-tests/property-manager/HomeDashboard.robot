*** Settings ***
Library           Selenium2Library

*** Variables ***
&{schedule1}      paymentNo=1    description=Excavation    amount=200
&{schedule2}      paymentNo=2    description=Plinth Completion    amount=3000    expectedAmount=200

*** Test Cases ***
Adding payment item to payment schedule list
    [Documentation]    Should be able to add item to the schedule list
    Open Browser    http://localhost:8099/property-manager/#!/payments/schedule
    Input Text    id=qa-payment-number    ${schedule1["paymentNo"]}
    Input Text    id=qa-payment-description    ${schedule1["description"]}
    Input Text    id=qa-payment-amount    ${schedule1["amount"]}
    Click Button    id=qa-add-item
    Table Cell Should Contain    id=qa-payment-schedule-tab    2    1    ${schedule1["paymentNo"]}
    Table Cell Should Contain    id=qa-payment-schedule-tab    2    2    ${schedule1["description"]}
    Table Cell Should Contain    id=qa-payment-schedule-tab    2    3    ${schedule1["amount"]}
    Click Button    id=qa-add-item
    [Teardown]    Close Browser

Payment items should be orders by payment number
    [Documentation]    Should be able to add item to the schedule list
    Open Browser    http://localhost:8099/property-manager/#!/payments/schedule
    Input Text    id=qa-payment-number    ${schedule2["paymentNo"]}
    Input Text    id=qa-payment-description    ${schedule2["description"]}
    Input Text    id=qa-payment-amount    ${schedule2["amount"]}
    Click Button    id=qa-add-item
    Input Text    id=qa-payment-number    ${schedule1["paymentNo"]}
    Input Text    id=qa-payment-description    ${schedule1["description"]}
    Input Text    id=qa-payment-amount    ${schedule1["amount"]}
    Click Button    id=qa-add-item
    Table Cell Should Contain    id=qa-payment-schedule-tab    2    1    ${schedule1["paymentNo"]}
    Table Cell Should Contain    id=qa-payment-schedule-tab    2    2    ${schedule1["description"]}
    Table Cell Should Contain    id=qa-payment-schedule-tab    2    3    ${schedule1["amount"]}
    Table Cell Should Contain    id=qa-payment-schedule-tab    3    1    ${schedule2["paymentNo"]}
    Table Cell Should Contain    id=qa-payment-schedule-tab    3    2    ${schedule2["description"]}
    Table Cell Should Contain    id=qa-payment-schedule-tab    3    3    ₹3,000.00
    [Teardown]    Close Browser

Payment schedule should be saved successfully
    [Documentation]    Should be able to add item to the schedule list
    Open Browser    http://localhost:8099/property-manager/#!/payments/schedule
    Input Text    id=qa-payment-number    ${schedule1["paymentNo"]}
    Input Text    id=qa-payment-description    ${schedule1["description"]}
    Input Text    id=qa-payment-amount    ${schedule1["amount"]}
    Click Button    id=qa-add-item
    Table Cell Should Contain    id=qa-payment-schedule-tab    2    1    ${schedule1["paymentNo"]}
    Table Cell Should Contain    id=qa-payment-schedule-tab    2    2    ${schedule1["description"]}
    Table Cell Should Contain    id=qa-payment-schedule-tab    2    3    ${schedule1["amount"]}
    Click Button    id=qa-add-item
    Click Button    id=qa-payment-schedule-save-btn
    Comment    Page Should Contain    Details saved successfully !
    [Teardown]    Close Browser
