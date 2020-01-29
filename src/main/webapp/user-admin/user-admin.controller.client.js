(function () {
    let $usernameFld, $passwordFld;
    let $searchBtn, $createBtn, $updateBtn;
    let $removeBtn, $editBtn;
    let $firstNameFld, $lastNameFld, $roleFld;
    let $username, $password, $firstName, $lastName, $role;
    let $userRowTemplate, $tbody;
    let userId;

    let userService = new AdminUserServiceClient();
    let user = new User();

    $(main);

    function main () {

        $usernameFld = $("#usernameFld");
        $passwordFld = $("#passwordFld");
        $firstNameFld = $("#firstNameFld");
        $lastNameFld = $("#lastNameFld");
        $roleFld = $("#roleFld");

        $searchBtn = $("#wbdv-search");
        $searchBtn.click(function () {
            alert("search")
        });

        $createBtn = $("#wbdv-create");
        $createBtn.click(createUser);

        $updateBtn = $("#wbdv-update");
        $updateBtn.click(updateUser);

        $removeBtn = $("#wbdv-remove");
        $removeBtn.click(() => {
            alert("remove")
        });

        $editBtn = $("#wbdv-edit");
        $editBtn.click(function () {
            alert("edit")
        });

        $userRowTemplate = $("#wbdv-template");
        $tbody = $("#wbdv-tbody");

        $userId = -1;

        clearForm();
        findAllUsers();
    }


    const clearForm = () => {
        $usernameFld.val('');
        $passwordFld.val('');
        $firstNameFld.val('');
        $lastNameFld.val('');
        $roleFld.val('');
    };

    const readForm = () => {
        $username = $usernameFld.val();
        $password = $passwordFld.val();
        $firstName = $firstNameFld.val();
        $lastName = $lastNameFld.val();
        $role = $roleFld.val();
    };


    const createUser = () => {
        readForm();

        alert('create new user');

        user.setUsername($username);
        user.setPassword($password);
        user.setFirstName($firstName);
        user.setLastName($lastName);
        user.setRole($role);

        userService.createUser(user)
            .then(findAllUsers);

        clearForm();
    };

    const findAllUsers = () => {
        userService.findAllUsers()
            .then(renderUsers);
    };

    const findUserById = (uid) => {
        userService.findUserById(uid)
            .then(renderUser);
        userId = uid;
    };

    const deleteUser = (userId) => {
        userService.deleteUser(userId)
            .then(findAllUsers);
    };
    // function selectUser() { … }

    const updateUser = () => {
      readForm();
      user.setUsername($username);
      user.setPassword($password);
      user.setFirstName($firstName);
      user.setLastName($lastName);
      user.setRole($role);

      if(userId != -1){
          userService.updateUser(userId,user)
              .then(findAllUsers);
          clearForm();
          userId=-1;
      }

    };

    const renderUser = (user) => {
        $usernameFld.val(user.username);
        $passwordFld.val(user.password);
        $firstNameFld.val(user.firstName);
        $lastNameFld.val(user.lastName);
        $roleFld.val(user.role);
    };

    const renderUsers = (users) => {
        $tbody.empty();
        for (let u in users) {
            let user = users[u];
            let newRow = $userRowTemplate.clone();

            newRow.find("#rowUsername").html(user.username);
            newRow.find("#rowPassword").html(user.password);
            newRow.find("#rowFirstName").html(user.firstName);
            newRow.find("#rowLastName").html(user.lastName);

            newRow.find("#rowRole").html(user.role);
            newRow.find("#wbdv-remove").click(() => deleteUser(user._id));
            newRow.find("#wbdv-edit").click(() => findUserById(user._id));

            $tbody.append(newRow);
        }
    };


})();