# wellness

This repository is intended to host an app for evaluating mood, wellbeing and fuctioning as described by methods mentioned in the scale conversion section. It is borrowing ideas from a proprietary app called PocketWell which is tied to a webservice called [Wellness Together Canada](https://www.wellnesstogether.ca/en-ca/). From their website: "[WTC] was created in response to a rise in mental health and substance use concerns since the COVID-19 pandemic. It is funded by the Government of Canada."

In early 2024 WTC [announced it was going to shut down it's services](https://www.wellnesstogether.ca/en-ca/wtc-closure-information). As I personally found it useful to track my mood and functioning and wanted continuity with the rest of my tracked data (logget in Track & Graph on Android) I decided to implement a simple replacement app.

## Scale Conversions

I contacted the the website and asked a few clarifying questions about what science the tracking was based on, and as a followup question how they converted the particular number to a 0-100 scale (as the original reearch used non-unified scales): "[...] I am interested in how the various scales are adjusted from the respective values [(PHQ4 12, WEMWBS 70 and WSAS 40)] to the [unified] scale of 0-100."

Their response:

> "To display all three measures on the same dashboard, the Mood and Functioning scales were reversed and converted to a 0-100 scale whereas the Wellbeing scale was just converted to the 0-100 scale. This allowed all three measures to be displayed together where higher scores would be considered better and lower scores would be considered worse. The formulae below shows how scores on these scales (e.g., on the WTC dashboard) can be changed back to their original forms.
> 
> In the formulae below, Mood, Functioning, and Wellbeing scores are the results on the 0-100 scale as presented on the Wellness Together Canada or PocketWell dashboards. I’ve given an example for Mood, but the others would be calculated similarly."

### Mood:

based on *The Patient Health Questionnaire-4 (PHQ-4), developed by Kurt Kroenke, Robert L Spitzer, Janet B W Williams, and Bernd Löwe.*

    PHQ-4 score = 12-(Mood score/100)*12

Example for a mood score of 68:

    PHQ-4 score = 12-(68/100)*12
    PHQ-4 score = 12-8.16
    PHQ-4 score = 3.84

Rounded up, the equivalent score on the PHQ-4 would be 4.
Lower scores indicate better mood.

## Wellbeing

based on *The Warwick-Edinburgh Mental Well-being Scale (WEMWBS), developed by Ruth Tennant, Louise Hiller, Ruth Fishwick, Stephen Platt, Stephen Joseph, Scott Weich, Jane Parkinson, Jenny Secker, and Sarah Stewart-Brown.*

Wellbeing: (the original scale is out of 70, however the lowest score possible is 14 so the range is 56)

    WEMWBS score = 14+(Wellbeing score/100)*56

Higher scores indicate greater wellbeing.

### Functioning:

based on *The Work and Social Adjustment Scale (WSAS), developed by James C Mundt, Isaac M Marks, M Katherine Shear, and John H Greist.*

    WSAS score = 40-(Functioning score/100)*40

Lower scores indicate lower impairment.
