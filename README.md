# Home Insurance Quote Generator

[![License](https://img.shields.io/badge/license-MIT-blue.svg)](LICENSE.md)


## Description

A Java/Java FX application for generating tailor-made home-insurance quotes

This is a sample of a real-world application created for a ficticious insurance company called "AB Insurance":





## Usage



<details>

<summary>Entering Basic Info</summary>

Firstly, the user can provide the basic information that desires to be included in the quotation:

</details>

<details>

<summary>Selecting Covers/Deductibles</summary>

The user has the option to select a plan in which coverage components are automatically selected, while retaining the ability to check/uncheck any specific coverage item or condition individually:



This latter feature embodies the tailor-made element, as it allows users to personalize the coverage.

</details>

<details>

<summary>Submitting the Values (Building/Content)</summary>

The user is required to input the insured value for building and/or content. By pressing the "Submit" button, a set of pre-configured rules get into action and automatically calculate the limit of the selected covers:

</details>

<details>

<summary>Selecting Conditions/Special Agreements</summary>

The user has the capability to review and adjust contract clauses as needed: 

> [!NOTE]
> Regarding General Exclusions, given their obligatry nature, the relative fields are locked and not editable.


</details>

<details>

<summary>Adding Conditions/Special Agreements</summary>

Any contract clause that may not be initially included can be manually appended:



</details>

<details>

<summary>Generating the Quote</summary>

Finally, the quote is delivered in XLS format based on an xls source file:



</details>

<details>

<summary>Automation is the key to success</summary>

Apart from the main capabilities for covers, limits etc. other automations exist as well. For example, if the user selects "Secondary Residence" as residence type, since it is more vulnerable to theft, the field of theft measures is automatically checked and open for editing:



</details>

## Notes

- The app could be adapted for use with business products as well
- Other automations could be implemented based on the user's needs and underwriting rules
- .ODS and .XLSX files could be utilized (minor changes in the code are necessary)



## License

This project is licensed under the [MIT License](LICENSE). You are free to use, modify, and distribute this project as per the terms of the license.
