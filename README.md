# aldi-clickandcollect-bugfix
Temporary bug fix for Aldi Click and Collect

The issue stems from mobile devices pasting the entire clipboard content instantaneously while concurrently activating the input button. The provided solution addresses this problem by inserting each character from the clipboard with a default delay of 50 milliseconds and subsequently triggering the input button only after the entire clipboard content has been entered.

In addition, instead of throwing a generic error message the full error will be logged to allow for easier debugging.
