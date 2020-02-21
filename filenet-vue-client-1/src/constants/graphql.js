import gql from 'graphql-tag'

export const ROOT_FOLDERS_QUERY = gql`
  query {
    folder(path:"/") {
      subFolders {
        Name
        Creator
        DateCreated
      }
    }
  }`
