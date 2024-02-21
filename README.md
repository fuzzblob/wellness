# wellness

This repository is intended to host an app for evaluating mood, wellbeing and fuctioning as described by methods mentioned in the scale conversion section. It is borrowing ideas from a proprietary app called PocketWell which is tied to a webservice called [Wellness Together Canada](https://www.wellnesstogether.ca/en-ca/). From their website: "[WTC] was created in response to a rise in mental health and substance use concerns since the COVID-19 pandemic. It is funded by the Government of Canada."

In early 2024 WTC [announced it was going to shut down it's services](https://www.wellnesstogether.ca/en-ca/wtc-closure-information). As I personally found it useful to track my mood and functioning and wanted continuity with the rest of my tracked data (logget in Track & Graph on Android) I decided to implement a simple replacement app.

## Scale Conversions

I contacted the the website and asked a few clarifying questions about what science the tracking was based on, and as a followup question how they converted the particular number to a 0-100 scale (as the original reearch used non-unified scales): "[...] I am interested in how the various scales are adjusted from the respective values [(PHQ4 12, WEMWBS 70 and WSAS 40)] to the [unified] scale of 0-100."

Their response:

> "To display all three measures on the same dashboard, the Mood and Functioning scales were reversed and converted to a 0-100 scale whereas the Wellbeing scale was just converted to the 0-100 scale. This allowed all three measures to be displayed together where higher scores would be considered better and lower scores would be considered worse. The formulae below shows how scores on these scales (e.g., on the WTC dashboard) can be changed back to their original forms.
> 
> In the formulae below, Mood, Functioning, and Wellbeing scores are the results on the 0-100 scale as presented on the Wellness Together Canada or PocketWell dashboards. I've given an example for Mood, but the others would be calculated similarly."

### Mood:

based on *"The Patient Health Questionnaire-4 (PHQ-4), developed by Kurt Kroenke, Robert L Spitzer, Janet B W Williams, and Bernd Löwe."*

    PHQ-4 score = 12-(Mood score/100)*12

Example for a mood score of 68:

    PHQ-4 score = 12 - (68 / 100) * 12
    PHQ-4 score = 12 - 8.16
    PHQ-4 score = 3.84

Rounded up, the equivalent score on the PHQ-4 would be 4.
Lower scores indicate better mood.

### PHQ-4

Scale:

0. Not at all
1. Several days
2. More than half the days
3. Nearly every day

Prompts:

- Over the last 2 weeks, how often have you been bothered by feeling nervous, anxious or on edge?
- Over the last 2 weeks, how often have you been bothered by not being able to stop or control worrying?
- Over the last 2 weeks, how often have you been bothered by little interest or pleasure in doing things?
- Over the last 2 weeks, how often have you been bothered by feeling down, depressed, or hopeless?

Scoring (Utah method):

PHQ-4 total score ranges from 0 to 12, with categories of psychological distress being:

- None 0-2
- Mild 3-5
- Moderate 6-8
- Severe 9-12

Anxiety subscale = sum of items 1 and 2 (score range, 0 to 6)
Depression subscale = sum of items 3 and 4 (score range, 0 to 6)
On each subscale, a score of 3 or greater is considered positive for screening purposes

## Wellbeing

based on *"The Warwick-Edinburgh Mental Well-being Scale (WEMWBS), developed by Ruth Tennant, Louise Hiller, Ruth Fishwick, Stephen Platt, Stephen Joseph, Scott Weich, Jane Parkinson, Jenny Secker, and Sarah Stewart-Brown."*

Wellbeing: (the original scale is out of 70, however the lowest score possible is 14 so the range is 56)

    WEMWBS score = 14 + (Wellbeing score / 100) * 56

Higher scores indicate greater wellbeing.

### Warwick Edinburgh Mental Well-Being Scale (WEMWBS)

Below are some statements about feelings and thoughts. Please tick the box that best describes your experience of each over the last 2 weeks

Rating:

1. None of the time
2. Rarely
3. Some of the time
4. Often
5. All of the time

Prompts:

- I've been feeling optimistic about the future
- I've been feeling useful
- I've been feeling relaxed
- I've been feeling interested in other people
- I've had energy to spare
- I've been dealing with problems well
- I've been thinking clearly
- I've been feeling good about myself
- I've been feeling close to other people
- I've been feeling confident
- I've been able to make up my own mind about things
- I've been feeling loved
- I've been interested in new things
- I've been feeling cheerful

### Functioning:

based on *"The Work and Social Adjustment Scale (WSAS), developed by James C Mundt, Isaac M Marks, M Katherine Shear, and John H Greist."*

    WSAS score = 40 - (Functioning score / 100) * 40

Lower scores indicate lower impairment.

#### Work and Social Adjustment Scale

Rate each of the following questions on a 0 to 8 scale: 0 indicates no impairment at all and 8 indicates very severe impairment.

		0 means not at all impaired and 8 means very severely impaired to the point I can't work.
		0 means not at all impaired and 8 means very severely impaired.

- Because of my [disorder], my ability to work is impaired. 
- Because of my [disorder], my home management (cleaning, tidying, shopping, cooking, looking after home or children, paying bills) is impaired.
- Because of my [disorder], my social leisure activities (with other people, such as parties, bars, clubs, outings, visits, dating, home entertainment) are impaired.
- Because of my [disorder], my private leisure activities (done alone, such as reading, gardening, collecting, sewing, walking alone) are impaired.
- Because of my [disorder], my ability to form and maintain close relationships with others, including those I live with, is impaired.
