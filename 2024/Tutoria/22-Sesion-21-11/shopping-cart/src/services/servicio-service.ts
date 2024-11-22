import axios from 'axios';
import { API_BASE_URL } from './api-config';

const SERVICIO_API_URL = `${API_BASE_URL}/servicio`;

interface ServicioData {
  codigo: string;
  nombre: string;
  precioUnitario: number;
}

export const getAllServicios = async (): Promise<any> => {
  try {
    const { data } = await axios.get(SERVICIO_API_URL);
    return data;
  } catch (error) {
    console.error('Error al obtener servicios:', error);
    throw error;
  }
};

export const findServicioById = async (id: number): Promise<any> => {
  try {
    const { data } = await axios.get(`${SERVICIO_API_URL}/${id}`);
    return data;
  } catch (error) {
    console.error(`Error al obtener servicio ID ${id}:`, error);
    throw error;
  }
};

export const saveServicio = async (servicioData: ServicioData): Promise<any> => {
  try {
    const { data } = await axios.post(SERVICIO_API_URL, servicioData);
    return data;
  } catch (error) {
    console.error('Error al guardar servicio:', error);
    throw error;
  }
};

export const updateServicio = async (servicioData: ServicioData, id: number): Promise<any> => {
  try {
    const { data } = await axios.put(`${SERVICIO_API_URL}/${id}`, servicioData);
    return data;
  } catch (error) {
    console.error(`Error al actualizar servicio ID ${id}:`, error);
    throw error;
  }
};

export const deleteServicio = async (id: number): Promise<any> => {
  try {
    const { data } = await axios.delete(`${SERVICIO_API_URL}/${id}`);
    return data;
  } catch (error) {
    console.error(`Error al eliminar servicio ID ${id}:`, error);
    throw error;
  }
};
