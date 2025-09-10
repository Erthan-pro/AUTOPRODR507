class ImageDocument:

    name: str
    contentType: str
    imageData: bytes

    def __init__(self, name: str, contentType: str, imageData: bytes):
        self.name = name
        self.contentType = contentType
        self.imageData = imageData