import flask
from flask_cors import CORS
from flask_pymongo import PyMongo

import models.image as image_model

if __name__ == "__main__":
    
    app = flask.Flask(__name__)
    CORS(app, resources={r"/api/*": {"origins": "*"}})

    app.config['MONGO_URI'] = 'mongodb://root:butinfo@localhost:27017/?authSource=admin'
    mongo = PyMongo(app)

    @app.route('/')
    def index():
        return flask.render_template('index.html')

    @app.route('/api/images/upload', methods=['POST'])
    def upload_image():
        
        file = flask.request.files.get('file')
        if not file:
            return flask.jsonify({"error": "No file provided"}), 400    
        
        filename = file.filename

        image = image_model.ImageDocument(
            name=filename,
            contentType=file.content_type,
            imageData=file.read()
        )
        mongo.cx["admin"]["images"].insert_one(image.__dict__)

        return flask.jsonify({"message": f"File {filename} uploaded successfully"}), 200

    app.run(port=8080, debug=True)
