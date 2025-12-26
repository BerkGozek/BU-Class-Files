import matplotlib.pyplot as plt
import numpy as np

# Prepare data using NumPy arrays
categories = np.array(['Category A', 'Category B', 'Category C', 'Category D'])
values = np.array([25, 40, 15, 50])

# Create the bar chart
plt.bar(categories, values, color='skyblue', width=0.7)

# Add labels and title
plt.xlabel('Categories')
plt.ylabel('Values')
plt.title('Sample Bar Chart with NumPy Data')

# Display the chart
plt.show()
