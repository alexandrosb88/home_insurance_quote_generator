# Home Insurance Quote Generator

[![License](https://img.shields.io/badge/license-MIT-blue.svg)](LICENSE.md)


## Description

> ### Java/Java FX application for generating tailor-made home-insurance quotes
<br />
<br />

This is a sample of a real-world application. 

In order to showcase its funcionality, it is recreated for a ficticious insurance company "AB Insurance".

Main Screen:

![main_screen](main_screen.png)



## Usage
<br />

> *(click each section to expand)*

<br />

<details>

<summary>Entering Basic Info</summary>
<br />

Firstly, the user provides basic information that wishes to be included in the quotation:

![info](info.png)

</details>

<details>

<summary>Selecting Covers/Deductibles</summary>
<br />


The initial option involves selecting a plan wherein predetermined coverage components are automatically checked:

![plan_selection](plan_selection.gif)


However, the user retains the ability to check/uncheck any specific coverage item or condition individually:

![cover_selection](cover_selection.gif)

> **Note** <br />
This latter feature embodies the tailor-made element, as it allows users to personalize the coverage.
<br />

When a cover is selected, the relative field appears in the deductible section. If a deductible box is checked, the text is open for editing:

![deductibles](deductibles.gif)

</details>

<details>

<summary>Submitting the Values (Building/Content)</summary>
<br />

After selecting the desired covers, the user is then required to input the insured value for building and/or content. By pressing the "Submit" button, a set of pre-configured rules get into action and automatically calculate the limit of the selected covers:

![submit_values](submit_values.gif)

</details>

<details>

<summary>Selecting Conditions/Special Agreements</summary>
<br />

There is capability to review and adjust contract clauses as needed: 

![clauses](clauses.gif)


> **Note** <br />
Regarding General Exclusions, given their obligatory nature, the relative fields are locked and not editable<br /> (However, this feature could be easily adjusted in source code level)


</details>

<details>

<summary>Adding Conditions/Special Agreements</summary>
<br />

Any contract clause that may not be initially included can be manually appended:

![add_condition](add_condition.gif)

</details>

<details>

<summary>Generating the Quote</summary>
<br />

Finally, by pressing "Generate Quote" the quote is delivered in XLS format based on an xls source file:

![generate](generate.gif)

<br />

![output1](output1.PNG)

![output2](output2.PNG)

<br />

</details>

<details>

<summary>Automation is the key to success!</summary>
<br />

Apart from the main capabilities for covers, limits etc. other automations can be implemented based on the user needs and underwriting rules.
<br />
<br />
For example, if the user selects "Secondary Residence" as residence type, since it is more vulnerable to theft, the field of theft measures is automatically checked and open for editing.



</details>

## Notes

- The app could be adapted for use with business products as well
- Libre office and xls files were employed
- .ODS and .XLSX files could be utilized (minor changes in the code are necessary)



## License

This project is licensed under the [MIT License](LICENSE). You are free to use, modify, and distribute this project as per the terms of the license.
