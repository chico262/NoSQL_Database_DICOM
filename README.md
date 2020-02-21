Dicoogle Plugin - Sample 
========================

This is a Dicoogle plugin to serve as an example. Those that are interested in developing a new
plugin may use this one as a template.

Getting Started
---------------

### Installing and running Dicoogle

1. Go to http://www.dicoogle.com/downloads/
2. Download Dicoogle
3. Extract your contents to its own directory (e.g. "~/dicoogle" or "C:\dicoogle", depending on the platform).
4. Run Dicoogle with: sh DicoogleClient.sh (OSX / Linux) or DicoogleClient.bat (Windows).
5. You should see your web browser opening the Dicoogle user interface. Is it running? You're ok!

### Downloading and building the plugin

Maven is required in order to build the project. An IDE with Maven support such as Netbeans may also help.

1. Clone this git repository

2. Go to the project's base directory in a command line and run `mvn install`. Alternatively, open
   the Maven project of the plugin with your IDE, then force it to build your project.

3. If the building task is successful, you will have a new jar with dependencies in the target
   folder (target/dicoogle-plugin-sample-2.5.0-jar-with-dependencies.jar).

### Developing your own plugin based on this sample

The first class to look into is SamplePluginSet. It is the main entry point for everything else.
Once modified to suit your needs, build the plugin again and re-deploy it to Dicoogle (see below).

### Using your plugin

1. Copy your plugin's package with dependencies (target/dicoogle-plugin-sample-2.5.0-jar-with-dependencies.jar)
   to the "Plugins" folder inside the root folder of Dicoogle.

2. Run Dicoogle. The plugin will be automatically included.

Available content
-----------------

- _SampleIndexer_ : a sample indexer, only logs the DIM contents of files
- _SampleStorage_ : a sample storage service, keeps files in memory buffers
- _SampleQuery_ : a sample query provider, returns random data on request
- _SampleJettyPlugin_ : a sample plugin for providing web services, holds `SampleWebService`
- _SampleWebService_ : a sample web service in the form of a servlet, serves a web page and a few other services

Web service plugin sample and Web App: 
--------------------------------------

To test the webservice plugin, you may open your browser and navigate to these URLs:

- `http://localhost:8080/sample/hello?uid=1111`

You may also use the built-in Dicoogle services for testing other plugins:

- GET `http://localhost:8080/search?query=test&provider=RSI` to test the query provider
- POST `http://localhost:8080/management/tasks/index?plugin=RSI&uri=<file:/path/to/DICOM/dir>` to test the indexer

Platforms
----------

Dicoogle has been tested in:

- Windows
- Linux
- Mac OS X

For more information, please visit http://www.dicoogle.com

