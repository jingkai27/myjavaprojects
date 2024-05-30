# -*- coding: utf-8 -*- #
# Copyright 2015 Google LLC. All Rights Reserved.
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#    http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
"""Resource definitions for cloud platform apis."""

import enum


BASE_URL = 'https://gkemulticloud.googleapis.com/v1/'
DOCS_URL = 'https://www.google.com'


class Collections(enum.Enum):
  """Collections for all supported apis."""

  PROJECTS = (
      'projects',
      'projects/{projectsId}',
      {},
      ['projectsId'],
      True
  )
  PROJECTS_LOCATIONS = (
      'projects.locations',
      'projects/{projectsId}/locations/{locationsId}',
      {},
      ['projectsId', 'locationsId'],
      True
  )
  PROJECTS_LOCATIONS_AWSCLUSTERS = (
      'projects.locations.awsClusters',
      '{+name}',
      {
          '':
              'projects/{projectsId}/locations/{locationsId}/awsClusters/'
              '{awsClustersId}',
      },
      ['name'],
      True
  )
  PROJECTS_LOCATIONS_AWSCLUSTERS_AWSNODEPOOLS = (
      'projects.locations.awsClusters.awsNodePools',
      '{+name}',
      {
          '':
              'projects/{projectsId}/locations/{locationsId}/awsClusters/'
              '{awsClustersId}/awsNodePools/{awsNodePoolsId}',
      },
      ['name'],
      True
  )
  PROJECTS_LOCATIONS_AZURECLIENTS = (
      'projects.locations.azureClients',
      '{+name}',
      {
          '':
              'projects/{projectsId}/locations/{locationsId}/azureClients/'
              '{azureClientsId}',
      },
      ['name'],
      True
  )
  PROJECTS_LOCATIONS_AZURECLUSTERS = (
      'projects.locations.azureClusters',
      '{+name}',
      {
          '':
              'projects/{projectsId}/locations/{locationsId}/azureClusters/'
              '{azureClustersId}',
      },
      ['name'],
      True
  )
  PROJECTS_LOCATIONS_AZURECLUSTERS_AZURENODEPOOLS = (
      'projects.locations.azureClusters.azureNodePools',
      '{+name}',
      {
          '':
              'projects/{projectsId}/locations/{locationsId}/azureClusters/'
              '{azureClustersId}/azureNodePools/{azureNodePoolsId}',
      },
      ['name'],
      True
  )
  PROJECTS_LOCATIONS_OPERATIONS = (
      'projects.locations.operations',
      '{+name}',
      {
          '':
              'projects/{projectsId}/locations/{locationsId}/operations/'
              '{operationsId}',
      },
      ['name'],
      True
  )

  def __init__(self, collection_name, path, flat_paths, params,
               enable_uri_parsing):
    self.collection_name = collection_name
    self.path = path
    self.flat_paths = flat_paths
    self.params = params
    self.enable_uri_parsing = enable_uri_parsing
