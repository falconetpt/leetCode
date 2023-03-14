import pandas as pd
from sklearn.feature_extraction.text import CountVectorizer
from sklearn.linear_model import LogisticRegression
from sklearn.metrics import classification_report
from sklearn.model_selection import train_test_split

# Load the data from a file
test_data = pd.read_csv('<path>/train_model.csv')

# Define the categories
categories = test_data['prediction'].unique()
print(categories)

# Split the data into training and test sets
X_train, X_test, y_train, y_test = train_test_split(test_data['text'], test_data['prediction'],
test_size=0.2, random_state=42, stratify=test_data['prediction'])

# Convert the text to lowercase
X_train = X_train.str.lower()
X_test = X_test.str.lower()

# Vectorize the training data using a count vectorizer
vectorizer = CountVectorizer()
X_train_vec = vectorizer.fit_transform(X_train)

# Train a logistic regression classifier
clf = LogisticRegression(max_iter=10000)
clf.fit(X_train_vec, y_train)

# Vectorize the test data using the same count vectorizer
X_test_vec = vectorizer.transform(X_test)

# Predict the labels for the test data
y_pred = clf.predict(X_test_vec)

# Print the classification report
print(classification_report(y_test, y_pred, target_names=categories))


# Load the test data from a file
test_data = pd.read_csv('<path>/failure_reasons.csv')

# Convert the text to lowercase
test_data["failure_reason"] = test_data["failure_reason"].str.lower()

# Vectorize the test data using the same count vectorizer
X_test_vec = vectorizer.transform(test_data["failure_reason"])

# Predict the labels for the test data
y_pred = clf.predict(X_test_vec)

# Export the predicted labels to a CSV file
test_data["predicted_label"] = y_pred
test_data.to_csv("predicted_labels.csv", index=False)
