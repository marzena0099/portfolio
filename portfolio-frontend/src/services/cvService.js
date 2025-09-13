import axios from 'axios';

export const downloadCv = async () => {
    try {
        const response = await axios.get('/api/cv', {
            responseType: 'blob'
        });


        const blob = new Blob([response.data], {type: 'application/pdf'});


        const fileName = 'Marzena_Bialonczyk_CV.pdf';

        const url = window.URL.createObjectURL(blob);
        const link = document.createElement('a');
        link.href = url;
        link.download = fileName;
        document.body.appendChild(link);
        link.click();
        link.remove();

        window.URL.revokeObjectURL(url);

        console.log('CV pobrane jako:', fileName);
    } catch (error) {
        console.error('Błąd przy pobieraniu CV:', error);
    }
};
