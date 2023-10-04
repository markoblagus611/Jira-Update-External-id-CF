## Jira Custom Field Auto-Updater

This script is designed to work as a listener in Jira, automating the updating of a custom field called 'External ID' whenever a new issue is created within the Jira system.

### How It Works

1. Upon the creation of a new issue, the script retrieves the current value of 'External ID' from the 'scripted-fields' property, which serves as our storage.

2. It increments the retrieved value by 1 to generate a new 'External ID.'

3. The script then updates the 'External ID' field for the newly created issue with the new value, and it also updates the 'scripted-fields' property.

### Purpose

The 'External ID' field functions as a unique identifier for issues within Jira, similar to the issue key. This script ensures that the 'External ID' remains up-to-date for every newly created issue, simplifying issue tracking and management.

Feel free to configure and deploy this script in your Jira environment to streamline your workflow.