const reloadButton = document.createElement('button');
reloadButton.textContent = 'Reload Page';
reloadButton.addEventListener('click', () => {
  location.reload();
});
