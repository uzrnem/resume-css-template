function findById(id) {
  return new Promise((resolve, reject) => {
    if (id > 0) {
      resolve('{user:"bhagyesh"}');
    } else {
      reject(new Error('user not found'));
    }
  });
}

var err = null;
console.log(await findById(-1).catch(e => err = e) )

findById(1)
  .then((mail) => {
    console.log("Got iD: ", mail);
  })
  .catch((err) => {
    console.log("Failed: " , err);
  })
  .finally(() => {
    console.log('Experiment completed');
  });
