document.addEventListener('DOMContentLoaded', () => {

    let libros = [

        { id: 1, titulo: "Cien Años de Soledad", autor: "Gabriel García Márquez", categoria: "Novela", stock: 15, totalStock: 20 },
        { id: 2, titulo: "El Señor de los Anillos", autor: "J.R.R. Tolkien", categoria: "Fantasía", stock: 25, totalStock: 30 },
        { id: 3, titulo: "1984", autor: "George Orwell", categoria: "Distopía", stock: 10, totalStock: 10 },
        { id: 4, titulo: "Un Mundo Feliz", autor: "Aldous Huxley", categoria: "Distopía", stock: 0, totalStock: 8 },
        { id: 5, titulo: "Ficciones", autor: "Jorge Luis Borges", categoria: "Relatos", stock: 12, totalStock: 15 }

    ];


    let usuarios = [

        { id: 1, nombre: "Ana López", email: "ana@gmail.com", dni: "12345678A", telefono: "600111222", rol: "Cliente" },
        { id: 2, nombre: "Carlos Ruiz", email: "carlos@puntossuspensivos.com", dni: "87654321B", telefono: "611222333", rol: "Personal" },
        { id: 3, nombre: "María Fernández", email: "maria@gmail.com", dni: "56781234C", telefono: "622333444", rol: "Cliente" }

    ];


        const getAutores = () => [...new Set(libros.map(libro => libro.autor))];
        const getCategorias = () => [...new Set(libros.map(libro => libro.categoria))];

        const mainContent = document.getElementById('main__content');
        const menuLinks = document.querySelectorAll('.sidebar .menu a');
        const themeToggleButton = document.getElementById('theme__toggle');


        themeToggleButton.addEventListener('click', () => {

            document.body.classList.toggle('dark__mode');
            const isDarkMode = document.body.classList.contains('dark__mode');
            localStorage.setItem('theme', isDarkMode ? 'dark' : 'light');
            const icon = themeToggleButton.querySelector('i');
            const text = themeToggleButton.querySelector('span');

            if (isDarkMode) {

                icon.classList.remove('fa-moon');
                icon.classList.add('fa-sun');
                text.innerText = "Modo Claro";

            } else {

                icon.classList.remove('fa-sun');
                icon.classList.add('fa-moon');
                text.innerText = "Modo Oscuro";

            }

        });


        function loadTheme() {

            if (localStorage.getItem('theme') === 'dark') {

                document.body.classList.add('dark__mode');
                const icon = themeToggleButton.querySelector('i');
                const text = themeToggleButton.querySelector('span');
                icon.classList.remove('fa-moon');
                icon.classList.add('fa-sun');
                text.innerText = "Modo Claro";

            }

        }

    menuLinks.forEach(link => {

        link.addEventListener('click', (e) => {

            e.preventDefault();
            const sectionId = e.target.closest('a').getAttribute('data-section');
            document.querySelectorAll('.page').forEach(page => page.classList.remove('active'));
            const activePage = document.getElementById(sectionId);

            if (activePage) {
                activePage.classList.add('active');
            }

            menuLinks.forEach(l => l.classList.remove('active'));
            e.target.closest('a').classList.add('active');
            cargarContenido(sectionId);

        });

    });

        function cargarContenido(section) {
            switch (section) {

                case 'inicio':
                    renderInicio();
                    break;
                case 'libros':
                    renderLibros();
                    break;
                case 'autores':
                    renderAutores();
                    break;
                case 'categorias':
                    renderCategorias();
                    break;
                case 'usuarios':
                    renderUsuarios();
                    break;
                case 'disponibilidad':
                    renderDisponibilidad();
                    break;
            }
        }

    function renderInicio() {
        const totalLibros = libros.reduce((sum, libro) => sum + libro.stock, 0);
        const totalAutores = getAutores().length;
        const totalCategorias = getCategorias().length;
        const totalUsuarios = usuarios.length;

        document.getElementById('resumen__libros').innerText = totalLibros;
        document.getElementById('resumen__autores').innerText = totalAutores;
        document.getElementById('resumen__categorias').innerText = totalCategorias;
        document.getElementById('resumen__usuarios').innerText = totalUsuarios;
    }


    function renderDashboard() {
        const dispCount = document.getElementById('disponibles-count');
        const vendCount = document.getElementById('vendidos-count');
        const dispBar = document.getElementById('disponibilidad-bar');
        const dispPercent = document.getElementById('disponibilidad-percent');

        if (!dispCount || !vendCount || !dispBar || !dispPercent) return;

        const totalDisponibles = libros.reduce((sum, libro) => sum + libro.stock, 0);
        const totalInventario = libros.reduce((sum, libro) => sum + (libro.totalStock || libro.stock), 0);
        const totalVendidos = totalInventario - totalDisponibles;
        
        const porcentaje = totalInventario > 0 ? (totalDisponibles / totalInventario) * 100 : 0;
        
        dispCount.innerText = `Disponibles (${totalDisponibles})`;
        vendCount.innerText = `Vendidos (${totalVendidos})`;
        dispBar.style.width = `${porcentaje}%`;
        dispPercent.innerText = `${porcentaje.toFixed(0)}% disponible`;
    }

    function renderLibros() {

        const container = document.getElementById('libros__list');
        container.innerHTML = `
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Título</th>
                        <th>Autor</th>
                        <th>Categoría</th>
                        <th>Stock</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>

                    ${libros.map(libro => `
                        <tr>
                            <td>${libro.id}</td>
                            <td>${libro.titulo}</td>
                            <td>${libro.autor}</td>
                            <td>${libro.categoria}</td>
                            <td>${libro.stock}</td>
                            <td>
                                <button class="button__edit" data-id="${libro.id}">Editar</button>
                                <button class="button__delete" data-id="${libro.id}">Eliminar</button>
                            </td>
                        </tr>

                    `).join('')}
                </tbody>
            </table>
        `;
    }


    function renderAutores() {

        const container = document.getElementById('autores__list');
        const autores = getAutores();

        container.innerHTML = `

            <table>
                <thead><tr><th>Autor</th></tr></thead>
                <tbody>
                    ${autores.map(autor => `<tr><td>${autor}</td></tr>`).join('')}
                </tbody>
            </table>`;
    }


    function renderCategorias() {

        const container = document.getElementById('categorias__list');
        const categorias = getCategorias();

        container.innerHTML = `
            <table>
                <thead><tr><th>Categoría</th></tr></thead>
                <tbody>
                    ${categorias.map(cat => `<tr><td>${cat}</td></tr>`).join('')}
                </tbody>
            </table>`;
    }


    function renderUsuarios() {

        const container = document.getElementById('usuarios__list');

        container.innerHTML = `

            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nombre</th>
                        <th>DNI</th>
                        <th>Teléfono</th>
                        <th>Email</th>
                        <th>Rol</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>

                    ${usuarios.map(user => `

                        <tr>
                            <td>${user.id}</td>
                            <td>${user.nombre}</td>
                            <td>${user.dni || '-'}</td>
                            <td>${user.telefono || '-'}</td>
                            <td>${user.email}</td>
                            <td>${user.rol}</td>
                            <td>
                                <button class="button__edit" data-id="${user.id}">Editar</button>
                                <button class="button__delete" data-id="${user.id}">Eliminar</button>
                            </td>
                        </tr>

                    `).join('')}

                </tbody>
            </table>`;
    }

    function renderDisponibilidad() {

        const container = document.getElementById('disponibilidad__list');
        const textoFiltro = document.getElementById('filtro-disponibilidad').value.toLowerCase();
        const estadoFiltro = document.getElementById('filtro-estado-select').value;

        const librosFiltrados = libros.filter(libro => {
            const cumpleTexto = libro.titulo.toLowerCase().includes(textoFiltro) || 
                                libro.autor.toLowerCase().includes(textoFiltro);
            
            let cumpleEstado = true;
            if (estadoFiltro === 'Disponible') cumpleEstado = libro.stock > 0;
            if (estadoFiltro === 'Agotado') cumpleEstado = libro.stock === 0;

            return cumpleTexto && cumpleEstado;
        });
            container.innerHTML = `

                <table>
                    <thead>
                        <tr>
                        <th>Título</th>
                        <th>Stock</th>
                        <th>Estado</th>
                        </tr>
                    </thead>
                    <tbody>

                        ${librosFiltrados.map(libro => `

                            <tr>

                                <td>${libro.titulo}</td>
                                <td>${libro.stock}</td>
                                <td>${libro.stock > 0 ? '<span style="color:green;">Disponible</span>' : '<span style="color:red;">Agotado</span>'}</td>

                            </tr>
                        `).join('')}
                    </tbody>
                </table>

        `;

        renderDashboard();
    };

        document.getElementById('filtro-disponibilidad').addEventListener('keyup', renderDisponibilidad);
        document.getElementById('filtro-estado-select').addEventListener('change', renderDisponibilidad);

        const modal = document.getElementById('modal__libro');
        const buttonNuevoLibro = document.getElementById('button__libro');
        const closeModal = document.querySelector('.close__button');
        const formLibro = document.getElementById('form__libro');



        buttonNuevoLibro.onclick = () => {

            formLibro.reset();
            document.getElementById('libro__id').value = '';
            document.getElementById('modal__titulo__libro').innerText = "Añadir Nuevo Libro";
            modal.style.display = 'block';

        }

        closeModal.onclick = () => {
            modal.style.display = 'none';
        }

        window.onclick = (event) => {
            if (event.target == modal) {

                modal.style.display = 'none';

            }

        }

        formLibro.addEventListener('submit', (e) => {
            e.preventDefault();
            const id = document.getElementById('libro__id').value;
            const stockVal = parseInt(document.getElementById('stock').value); // Corregida variable huérfana

            const nuevoLibroData = {
                titulo: document.getElementById('titulo').value,
                autor: document.getElementById('autor').value,
                categoria: document.getElementById('categoria').value,
                stock: stockVal
            };

            if (id) { 
                const index = libros.findIndex(l => l.id == id);
                libros[index] = { ...libros[index], ...nuevoLibroData };
            } else {
                libros.push({
                    id: Date.now(),
                    ...nuevoLibroData,
                    totalStock: stockVal
                });
            }
            modal.style.display = 'none';
            renderLibros();
            renderInicio();

            if(typeof renderDashboard === "function") renderDashboard();
        });


        document.getElementById('libros__list').addEventListener('click', (e) => {
                if (e.target.classList.contains('button__edit')) {
                    const id = e.target.dataset.id;
                    const libro = libros.find(l => l.id == id);
                    
                    document.getElementById('libro__id').value = libro.id;
                    document.getElementById('titulo').value = libro.titulo;
                    document.getElementById('autor').value = libro.autor;
                    document.getElementById('categoria').value = libro.categoria;
                    document.getElementById('stock').value = libro.stock;
                    
                    document.getElementById('modal__titulo__libro').innerText = "Editar Libro";
                    modal.style.display = 'block';
                }

                if (e.target.classList.contains('button__delete')) {
                    const id = e.target.dataset.id;
                    if (confirm('¿Estás seguro de que quieres eliminar este libro?')) {
                        libros = libros.filter(l => l.id != id);
                        renderLibros();
                        renderInicio();
                        renderDashboard();
                    }
                }
            });

        document.getElementById('filtro-disponibilidad').addEventListener('keyup', (e) => {

            renderDisponibilidad(e.target.value);

        });

        const modalUsuario = document.getElementById('modal__usuario');
        const buttonNuevoUsuario = document.getElementById('button__usuario');
        const formUsuario = document.getElementById('form__usuario');
        const closeLibroBtn = document.getElementById('close__libro');
        const closeUsuarioBtn = document.getElementById('close__usuario');

        buttonNuevoUsuario.addEventListener('click', () => {

            formUsuario.reset();
            document.getElementById('usuario__id').value = '';
            document.getElementById('modal__titulo__usuario').innerText = "Añadir Nuevo Usuario";
            modalUsuario.style.display = 'block';
        });



        closeUsuarioBtn.onclick = () => {
            modalUsuario.style.display = 'none';

        };

        formUsuario.addEventListener('submit', (e) => {
            e.preventDefault();
            const id = document.getElementById('usuario__id').value;

            const datosUsuario = {
                nombre: document.getElementById('usuario__nombre').value,
                email: document.getElementById('usuario__email').value,
                dni: document.getElementById('usuario__dni').value,
                telefono: document.getElementById('usuario__telefono').value,
                rol: document.getElementById('usuario__rol').value
            };

            if (id) {
                const index = usuarios.findIndex(u => u.id == id);
                if (index !== -1) {
                    usuarios[index] = { ...usuarios[index], ...datosUsuario };
                }
            } else {
                const nuevoUsuario = { 
                    id: Date.now(), 
                    ...datosUsuario 
                };
                usuarios.push(nuevoUsuario);
            }

            modalUsuario.style.display = 'none';
            renderUsuarios();
            if(typeof renderInicio === "function") renderInicio();
        });




    document.getElementById('usuarios__list').addEventListener('click', (e) => {

        const btn = e.target;
        const id = btn.dataset.id;

            if (btn.classList.contains('button__edit')) {
                const usuario = usuarios.find(u => u.id == id);
                if (usuario) {
                    document.getElementById('usuario__id').value = usuario.id;
                    document.getElementById('usuario__nombre').value = usuario.nombre;
                    document.getElementById('usuario__email').value = usuario.email;
                    document.getElementById('usuario__dni').value = usuario.dni || '';
                    document.getElementById('usuario__telefono').value = usuario.telefono || '';
                    document.getElementById('usuario__rol').value = usuario.rol;
                    
                    document.getElementById('modal__titulo__usuario').innerText = "Editar Usuario";
                    modalUsuario.style.display = 'block';
                }
            }

        if (btn.classList.contains('button__delete')) {
            if (confirm('¿Estás seguro de eliminar este usuario?')) {

                usuarios = usuarios.filter(u => u.id != id);

                renderUsuarios();
            }
        }
    });



        document.getElementById('close__usuario').onclick = () => {

            modalUsuario.style.display = 'none';

        };



        window.onclick = (event) => {
            if (event.target == modal) modal.style.display = 'none';
            if (event.target == modalUsuario) modalUsuario.style.display = 'none';
        };


    loadTheme();
    cargarContenido('inicio');

});