# Company Wise

Gradle subproject containing company-specific preparation material.

Layout:

- PDFs are stored at `src/main/resources/{Company}/Leetcode.pdf`
- Java package roots are stored at `src/main/java/com/coding/companywise/{company_slug}`

Notes:

- `{Company}` preserves the display name from the original PDF file name
- `{company_slug}` is a normalized lowercase package-safe name derived from the company name
