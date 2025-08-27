import axios from 'axios';

export const downloadCv = async () => {
    try {
        const response = await axios.get('http://localhost:8080/api/cv', {
            responseType: 'blob'
        });

        const url = window.URL.createObjectURL(new Blob([response.data]));
        const link = document.createElement('a');
        link.href = url;

        const contentDisposition = response.headers['content-disposition'];
        let fileName = 'CV.pdf';
        if (contentDisposition) {
            const match = contentDisposition.match(/filename\*?=['"]?UTF-8''(.+)/);
            if (match && match[1]) {
                fileName = decodeURIComponent(match[1]);
            }
        }

        link.setAttribute('download', fileName);
        document.body.appendChild(link);
        link.click();
        link.remove();
        window.URL.revokeObjectURL(url);

    } catch (error) {
        console.error('Błąd przy pobieraniu CV:', error);
    }
};
