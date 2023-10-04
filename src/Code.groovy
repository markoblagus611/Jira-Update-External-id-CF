// Get the project key of the trigger issue
def projectKey = issue.fields.project.key as String

// Retrieve the existing scripted field property for the project
def response = get("/rest/api/2/project/$projectKey/properties/scripted-fields")
        .header('Content-Type', 'application/json')
        .asObject(Map)

// Extract the current value of the scripted field property (oldExternalKey)
def oldExternalKey = response.body.value.value as String

// Split the oldExternalKey to isolate the numeric part
String[] array = oldExternalKey.split("-")

// Parse the numeric part
def number = array[1].toInteger()

// Generate a new external key by combining the project key and the incremented number
def newExternalKeyNumber = projectKey + "-" + (number + 1)

// Update the custom field 'externalID' of the trigger issue with the newExternalKeyNumber
def response2 = put("/rest/api/2/issue/${issue.key}")
        .header('Content-Type', 'application/json')
        .body([
                fields: [
                        customfield_id: newExternalKeyNumber
                ]
        ])
        .asString()

// Update the 'scripted-fields' property's value for the project
def newProperty = put("/rest/api/2/project/$projectKey/properties/scripted-fields")
        .header('Content-Type', 'application/json')
        .body(
                value: newExternalKeyNumber
        )
        .asString()