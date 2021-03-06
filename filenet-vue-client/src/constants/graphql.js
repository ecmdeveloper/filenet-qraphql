import gql from 'graphql-tag'

export const LOGIN_MUTATION = gql`
mutation Login($username: String!, $password: String!) {
  logon(username: $username, password: $password)
}
`

export const FOLDER_CONTENT = gql`
query FolderContent($path: String!) {
  folder(path: $path) {
    PathName
    subFolders {
      Name
      PathName
      Creator
      DateCreated
      ClassName
    }
    containedDocuments {
      Name
      Creator
      DateCreated
    }
  }
}
`
