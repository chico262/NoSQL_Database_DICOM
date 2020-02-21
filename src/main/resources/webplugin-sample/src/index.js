/* global Dicoogle */

export default class MyPlugin {

    constructor() {
        // TODO initialize plugin here
    }

    /**
     * @param {DOMElement} parent
     * @param {DOMElement} slot
     */
    render(parent, slot) {
        // create text input
        const txtAetitle = document.createElement('input');
        txtAetitle.type = 'text';
        txtAetitle.className = 'form-control';
        txtAetitle.style = `
            display: inline-block;
            width: 16em;
            margin-right: 1em;
        `;
        txtAetitle.disabled = true;
        parent.appendChild(txtAetitle);

        // create feedback label
        const lblFeedback = document.createElement('span');
        parent.appendChild(lblFeedback);

        // request for the current AE title
        Dicoogle.getAETitle((err, aetitle) => {
            if (err) {
                console.error("Service failure", err);
                return;
            }
            // put value in text box and make it editable
            txtAetitle.value = aetitle;
            txtAetitle.disabled = false;
        });

}

}
