import gql from 'graphql-tag'

export const LOGIN_MUTATION = gql`
mutation Login($username: String!, $password: String!) {
  logon(username: $username, password: $password)
}
`

export const FOLDER_CONTENT = gql`
query FolderContent($path: String!) {
  folder(path: $path) {
    subFolders {
      Name
      Creator
      DateCreated
      ClassName
    }
  }
}
`
