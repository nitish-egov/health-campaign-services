import config from ".";
const createAndSearch: any = {
    "facility": {
        requiresToSearchFromSheet: [
            {
                sheetColumnName: "Facility Code",
                searchPath: "Facility.id"
            }
        ],
        boundaryValidation: {
            column: "Boundary Code"
        },
        sheetSchema: {
            "$schema": "http://json-schema.org/draft-07/schema#",
            "title": "FacilityTemplateSchema",
            "type": "object",
            "properties": {
                "Facility Name": {
                    "type": "string",
                    "maxLength": 2000,
                    "minLength": 1
                },
                "Facility Type": {
                    "type": "string",
                    "enum": ["Warehouse", "Health Facility"]
                },
                "Facility Status": {
                    "type": "string",
                    "enum": ["Temporary", "Permanent"]
                },
                "Capacity": {
                    "type": "integer",
                    "minimum": 0,
                    "maximum": 9223372036854775807,
                    "multipleOf": 1
                }
            },
            "required": [
                "Facility Name",
                "Facility Type",
                "Facility Status",
                "Capacity"
            ],
            "unique": [
                "Facility Name"
            ]
        },
        uniqueIdentifier: "id",
        uniqueIdentifierColumn: "A",
        uniqueIdentifierColumnName: "Facility Code",
        matchEachKey: true,
        parseArrayConfig: {
            sheetName: "List of Available Facilities",
            parseLogic: [
                {
                    sheetColumn: "A",
                    sheetColumnName: "Facility Code",
                    resultantPath: "id",
                    type: "string"
                },
                {
                    sheetColumn: "B",
                    sheetColumnName: "Facility Name",
                    resultantPath: "name",
                    type: "string"
                },
                {
                    sheetColumn: "C",
                    sheetColumnName: "Facility Type",
                    resultantPath: "usage",
                    type: "string"
                },
                {
                    sheetColumn: "D",
                    sheetColumnName: "Facility Status",
                    resultantPath: "isPermanent",
                    type: "boolean",
                    conversionCondition: {
                        "Permanent": "true",
                        "Temporary": ""
                    }
                },
                {
                    sheetColumn: "E",
                    sheetColumnName: "Capacity",
                    resultantPath: "storageCapacity",
                    type: "number"
                },
                {
                    sheetColumn: "F",
                    sheetColumnName: "Boundary Code"
                }
            ],
            tenantId: {
                getValueViaPath: "ResourceDetails.tenantId",
                resultantPath: "tenantId"
            }
        },
        createBulkDetails: {
            limit: 50,
            createPath: "Facilities",
            url: config.host.facilityHost + "facility/v1/bulk/_create"
        },
        searchDetails: {
            searchElements: [
                {
                    keyPath: "tenantId",
                    getValueViaPath: "ResourceDetails.tenantId",
                    isInParams: true,
                    isInBody: false,
                },
                {
                    keyPath: "Facility",
                    isInParams: false,
                    isInBody: true,
                }
            ],
            searchLimit: {
                keyPath: "limit",
                value: "200",
                isInParams: true,
                isInBody: false,
            },
            searchOffset: {
                keyPath: "offset",
                value: "0",
                isInParams: true,
                isInBody: false,
            },
            url: config.host.facilityHost + "facility/v1/_search",
            searchPath: "Facilities"
        }
    },
    "boundary": {
        parseArrayConfig: {
            sheetName: "Sheet1",
        }
    },
    "user": {
        boundaryValidation: {
            column: "Boundary Code"
        },
        sheetSchema: {
            "$schema": "http://json-schema.org/draft-07/schema#",
            "title": "UserTemplateSchema",
            "type": "object",
            "properties": {
                "Name of the Person (Mandatory)": {
                    "type": "string",
                    "maxLength": 128,
                    "minLength": 1
                },
                "Phone Number": {
                    "type": "string",
                    "maxLength": 10,
                    "minLength": 10
                },
                "Role (Mandatory)": {
                    "type": "string",
                    "enum": [
                        "Registrar",
                        "Distributor",
                        "Monitor Local",
                        "Supervisor",
                        "Help Desk",
                        "Logistical officer"
                    ]
                },
                "Employment Type (Mandatory)": {
                    "type": "string",
                    "enum": ["Temporary", "Permanent"]
                },
                "Capacity": {
                    "type": "integer",
                    "minimum": 0,
                    "maximum": 9223372036854775807,
                    "multipleOf": 1
                }
            },
            "required": [
                "Name of the Person (Mandatory)",
                "Phone Number",
                "Role (Mandatory)",
                "Employment Type (Mandatory)",
            ],
            "unique": [
                "Phone Number"
            ]
        },
        parseArrayConfig: {
            sheetName: "Create List of Users",
            parseLogic: [
                {
                    sheetColumn: "A",
                    sheetColumnName: "Name of the Person (Mandatory)",
                    resultantPath: "name",
                    type: "string"
                },
                {
                    sheetColumn: "B",
                    sheetColumnName: "Phone Number",
                    resultantPath: "mobileNumber",
                    type: "string"
                },
                {
                    sheetColumn: "C",
                    sheetColumnName: "Role (Mandatory)",
                    resultantPath: "roles",
                    type: "array",
                    conversionCondition: {
                        "Monitor Local": [
                            {
                                "name": "Monitor Local",
                                "code": "MONITOR_LOCAL"
                            }
                        ]
                    }
                },
                {
                    sheetColumn: "D",
                    sheetColumnName: "Employment Type (Mandatory)"
                },
                {
                    sheetColumn: "E",
                    sheetColumnName: "Boundary Code"
                }
            ],
            tenantId: {
                getValueViaPath: "ResourceDetails.tenantId",
                resultantPath: "tenantId"
            }
        }
    }
}

export default createAndSearch;