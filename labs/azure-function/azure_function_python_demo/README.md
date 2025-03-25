# Prerequisites

Before you begin, ensure you have the following:

- **Azure Account**: If you don't have one, you can create a free account at [Azure Free Account](https://azure.microsoft.com/free/).
- **Python Installed**: Ensure you have Python 3.6, 3.7, 3.8, or 3.9 installed. You can download it from [python.org](https://www.python.org/).
- **Visual Studio Code (VS Code)**: Download and install from [code.visualstudio.com](https://code.visualstudio.com/).
- **Azure Functions Core Tools**: Install these tools to run and debug your functions locally. Installation instructions can be found in the [Azure Functions Core Tools documentation](https://learn.microsoft.com/azure/azure-functions/functions-run-local).
- **Azure Functions Extension for VS Code**: This extension streamlines the process of creating, debugging, and deploying Azure Functions. Install it from the [VS Code Marketplace](https://marketplace.visualstudio.com/).

---

# Step 1: Set Up Your Local Development Environment

1. **Open VS Code**: Launch Visual Studio Code.
2. **Install Python Extension**:

- Navigate to the Extensions view (`Ctrl+Shift+X`), search for "Python," and install the official extension by Microsoft.

3. **Install Azure Functions Extension**:

- Similarly, search for "Azure Functions" in the Extensions view and install the extension provided by Microsoft.

---

# Step 2: Create a New Azure Functions Project

1. **Initialize a New Project**:

- Press `F1` to open the command palette.
- Type and select `Azure Functions: Create New Project...`.
- Choose a directory for your project.
- Select **Python** as the language.
- Choose your preferred Python interpreter.
- Select a template for your first function, such as **HTTP trigger**.
- Provide a name for your function, e.g., `HttpExample`.
- Set the Authorization level to **Anonymous** (or another level based on your security requirements).

2. **Project Structure**: VS Code will generate a project with the following structure:

```plaintext
├── HttpExample
│   ├── __init__.py
│   └── function.json
├── local.settings.json
├── requirements.txt
└── host.json
```

- `__init__.py`: Contains the main code for your function.
- `function.json`: Defines the function's bindings and triggers.
- `local.settings.json`: Stores local configurations and settings.
- `requirements.txt`: Lists Python dependencies.
- `host.json`: Provides global configuration options for all functions in the app.

---

# Step 3: Develop Your Function

1. **Edit `__init__.py`**: Implement the desired functionality for your Azure Function. For example, an HTTP-triggered function might look like:

```python
import logging
import azure.functions as func

def main(req: func.HttpRequest) -> func.HttpResponse:
   logging.info('Python HTTP trigger function processed a request.')

   name = req.params.get('name')
   if not name:
      try:
        req_body = req.get_json()
      except ValueError:
        pass
      else:
        name = req_body.get('name')

   if name:
      return func.HttpResponse(f"Hello, {name}!")
   else:
      return func.HttpResponse(
        "Please pass a name on the query string or in the request body",
        status_code=400
      )
```

# Step 3: Run and Test Your Function

## 1. Ensure Prerequisites Are Installed

- **Azure Functions Core Tools**: Install it using Homebrew:

  ```bash
  brew tap azure/functions
  brew install azure-functions-core-tools@4
  ```

- **Python**: Ensure Python 3.8, 3.9, or 3.10 is installed (Azure Functions supports these versions).

- **Dependencies**: Install the required Python packages:

  ```bash
  source .venv/bin/activate  # Activate your virtual environment
  pip install -r requirements.txt
  ```

---

## 2. Start the Azure Function

Run the following command in the terminal from the root of your project directory (where `host.json` is located):

```bash
func start
```

---

## 3. Test the Function

Once the function starts, it will display a local URL, such as:

```
http://localhost:7071/api/HttpExample
```

You can test the function using a browser, `curl`, or a tool like Postman.

### Example Requests

- **GET Request**:

  ```bash
  curl "http://localhost:7071/api/HttpExample?name=Saravana"
  ```

  **Response**:

  ```
  Hello, Saravana. This HTTP triggered function executed successfully.
  ```

- **POST Request**:

  ```bash
  curl -X POST -H "Content-Type: application/json" -d '{"name": "Saravana"}' http://localhost:7071/api/HttpExample
  ```

  **Response**:

  ```
  Hello, Saravana. This HTTP triggered function executed successfully.
  ```

---

## 4. Stop the Function

Press `Ctrl+C` in the terminal to stop the Azure Function.

---

# Step 4: Deploy Your Function

1. **Sign In**:

- In VS Code, click on the Azure icon in the Activity Bar. Sign in to your Azure account if prompted.

2. **Create a Function App**:

- In the Azure Functions extension, click the "Create New Project" icon.
- Follow the prompts to create a new Function App in Azure, selecting the appropriate runtime stack (Python) and region.

3. **Deploy**:

- Right-click your local function project and select `Deploy to Function App`.

---
